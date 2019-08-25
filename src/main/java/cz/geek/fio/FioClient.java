package cz.geek.fio;

import static cz.geek.fio.FioExtractor.*;
import static org.apache.commons.lang3.Validate.*;
import static org.springframework.http.HttpMethod.*;

import java.io.OutputStream;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Fio Bank Client
 */
public class FioClient {

	private static final String ROOT = "{protocol}://{host}:{port}/ib_api/rest/";
	private static final String STATEMENT_BY_ID = ROOT + "by-id/{token}/{year}/{id}/transactions.{format}";
	private static final String STATEMENT_PERIODS = ROOT + "periods/{token}/{start}/{end}/transactions.{format}";
	private static final String STATEMENT_LAST = ROOT + "last/{token}/transactions.{format}";
	private static final String LAST_DATE = ROOT + "set-last-date/{token}/{date}/";
	private static final String LAST_ID = ROOT + "set-last-id/{token}/{id}/";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private final String token;
	private final String protocol;
	private final String host;
	private final String port;

	private final RestTemplate restTemplate;
	private final HttpMessageConverter<Object> jaxb2Converter;
	private final FioConversionService conversionService;

	/**
	 * Constructs a new Fio Client
	 * 
	 * @param token
	 *            API token
	 */
	public FioClient(final String token) {
		this(token, new FioClientSettings());
	}

	/**
	 * Constructs a new Fio Client
	 * 
	 * @param token
	 *            API token
	 * @param settings
	 *            HTTP settings
	 */
	public FioClient(final String token, FioClientSettings settings) {
		this("https", "www.fio.cz", 443, token, settings);
	}

	FioClient(final String protocol, final String host, final int port, final String token, final FioClientSettings settings) {
		this.protocol = notEmpty(protocol);
		this.host = notEmpty(host);
		this.port = Integer.toString(port);
		this.token = notEmpty(token);
		this.restTemplate = createRestTemplate(settings);
		this.jaxb2Converter = new NamespaceIgnoringJaxb2HttpMessageConverter();
		this.conversionService = new FioConversionService();
	}

	private RestTemplate createRestTemplate(final FioClientSettings settings) {
		final HttpClient httpClient = createHttpClientBuilder(settings).build();
		final RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
		restTemplate.setErrorHandler(new FioErrorHandler());
		return restTemplate;
	}

	private HttpClientBuilder createHttpClientBuilder(final FioClientSettings settings) {
		notNull(settings);

		final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setDefaultMaxPerRoute(settings.getMaxConnections());
		connectionManager.setMaxTotal(settings.getMaxConnections());

		final RequestConfig.Builder requestConfig = RequestConfig.copy(RequestConfig.DEFAULT);
		requestConfig.setConnectTimeout(settings.getConnectionTimeout());
		requestConfig.setConnectionRequestTimeout(settings.getConnectionRequestTimeout());
		requestConfig.setSocketTimeout(settings.getSocketTimeout());

		return HttpClientBuilder.create()
				// todo .setUserAgent(getUserAgent())
				.setConnectionManager(connectionManager)
				.setDefaultRequestConfig(requestConfig.build());
	}

	/**
	 * Get account statement within the given period
	 * 
	 * @param start
	 *            start date
	 * @param end
	 *            end date
	 * @return account statement
	 * @throws FioException
	 */
	public FioAccountStatement getStatement(final LocalDate start, final LocalDate end) {
		notNull(start);
		notNull(end);
		return restTemplate.execute(STATEMENT_PERIODS, GET, null,
				statementExtractor(jaxb2Converter, conversionService),
				protocol, host, port, token, DATE_FORMATTER.format(start), DATE_FORMATTER.format(end), ExportFormat.xml);
	}

	/**
	 * Export account statement within the given period
	 * 
	 * @param start
	 *            start date
	 * @param end
	 *            end date
	 * @param format
	 *            export format
	 * @param target
	 *            target stream
	 * @throws FioException
	 */
	public void exportStatement(final LocalDate start, final LocalDate end, final ExportFormat format, final OutputStream target) {
		notNull(start);
		notNull(end);
		notNull(format);
		restTemplate.execute(STATEMENT_PERIODS, GET, null, new OutputStreamResponseExtractor(target),
				protocol, host, port, token, DATE_FORMATTER.format(start), DATE_FORMATTER.format(end), format);
	}

	/**
	 * Get account statement with the given number within the given year
	 * 
	 * @param year
	 *            year
	 * @param id
	 *            statement number
	 * @return account statement
	 * @throws FioException
	 */
	public FioAccountStatement getStatement(final int year, final int id) {
		return restTemplate.execute(STATEMENT_BY_ID, GET, null,
				statementExtractor(jaxb2Converter, conversionService),
				protocol, host, port, token, year, id, ExportFormat.xml);
	}

	/**
	 * Export account statement with the given number within the given year
	 * 
	 * @param year
	 *            year
	 * @param id
	 *            statement number
	 * @param format
	 *            export format
	 * @param target
	 *            target stream
	 * @throws FioException
	 */
	public void exportStatement(final int year, final int id, final ExportFormat format, final OutputStream target) {
		notNull(format);
		restTemplate.execute(STATEMENT_BY_ID, GET, null, new OutputStreamResponseExtractor(target),
				protocol, host, port, token, year, id, format);
	}

	/**
	 * Get account statement from the last download
	 * 
	 * @return account statement
	 * @throws FioException
	 */
	public FioAccountStatement getStatement() {
		return restTemplate.execute(STATEMENT_LAST, GET, null,
				statementExtractor(jaxb2Converter, conversionService),
				protocol, host, port, token, ExportFormat.xml);
	}

	/**
	 * Export account statement from the last download
	 * 
	 * @param format
	 *            export format
	 * @param target
	 *            target stream
	 * @throws FioException
	 */
	public void exportStatement(final ExportFormat format, final OutputStream target) {
		notNull(format);
		restTemplate.execute(STATEMENT_LAST, GET, null, new OutputStreamResponseExtractor(target),
				protocol, host, port, token, format);
	}

	/**
	 * Set last downloaded statement by transaction id
	 * 
	 * @param id
	 *            transaction id
	 * @throws FioException
	 */
	public void setLast(final BigInteger id) {
		notNull(id);
		setLast(id.toString());
	}

	/**
	 * Set last downloaded statement by transaction id
	 * 
	 * @param id
	 *            transaction id
	 * @throws FioException
	 */
	public void setLast(final String id) {
		notEmpty(id);
		restTemplate.execute(LAST_ID, GET, null, null,
				protocol, host, port, token, id);
	}

	/**
	 * Set last downloaded statement by date
	 * 
	 * @param date
	 *            date
	 * @throws FioException
	 */
	public void setLast(final LocalDate date) {
		notNull(date);
		restTemplate.execute(LAST_DATE, GET, null, null,
				protocol, host, port, token, DATE_FORMATTER.format(date));
	}

}
