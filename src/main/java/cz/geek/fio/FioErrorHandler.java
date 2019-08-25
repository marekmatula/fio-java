package cz.geek.fio;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

class FioErrorHandler extends DefaultResponseErrorHandler {

	@Override
	public void handleError(final ClientHttpResponse response) throws IOException {
		final int statusCode = response.getRawStatusCode();

		switch (statusCode) {
			case HttpURLConnection.HTTP_CONFLICT:
				throw new FioTooMuchRequestsException(statusCode, response.getStatusText(), getResponseBody(response), getCharset(response));
			default:
				throw new FioRestException(statusCode, response.getStatusText(), getResponseBody(response), getCharset(response));
		}
	}

	@Override
	protected byte[] getResponseBody(final ClientHttpResponse response) {
		try {
			final InputStream responseBody = response.getBody();
			if (responseBody != null) {
				return FileCopyUtils.copyToByteArray(responseBody);
			}
		} catch (IOException ex) {
			// ignore
		}
		return new byte[0];
	}

	@Override
	protected Charset getCharset(final ClientHttpResponse response) {
		final HttpHeaders headers = response.getHeaders();
		final MediaType contentType = headers.getContentType();
		return contentType != null ? contentType.getCharSet() : Charset.forName("ISO-8859-1");
	}

}
