package cz.geek.fio;

import static org.apache.commons.lang3.Validate.*;

import cz.geek.fio.model.AccountStatement;
import cz.geek.fio.model.Info;
import cz.geek.fio.model.Transaction;
import cz.geek.fio.model.TransactionList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

class FioConversionService {

	private final GenericConversionService conversionService;

	public FioConversionService() {
		this.conversionService = new GenericConversionService();
		conversionService.addConverter(new AccountStatementConverter());
	}

	public <S, T> void validate(final Class<S> sourceClass, final Class<T> targetClass) {
		if (!conversionService.canConvert(sourceClass, targetClass)) {
			throw new IllegalArgumentException("Configured conversion service is not able to convert " + sourceClass + " to " + targetClass);
		}
	}

	public <T> T convert(final Object source, final Class<T> targetClass) {
		return conversionService.convert(source, targetClass);
	}

	static class AccountStatementConverter implements Converter<AccountStatement, FioAccountStatement> {

		private final AccountInfoConverter accountInfoConverter = new AccountInfoConverter();
		private final TransactionConverter transactionConverter = new TransactionConverter();

		@Override
		public FioAccountStatement convert(final AccountStatement statement) {
			notNull(statement);
			return new FioAccountStatement(
					accountInfoConverter.convert(statement.getInfo()),
					transactionConverter.convert(statement.getTransactionList()));
		}
	}

	static class AccountInfoConverter implements Converter<Info, FioAccountInfo> {

		@Override
		public FioAccountInfo convert(final Info source) {
			final FioAccountInfo info = new FioAccountInfo();
			info.setAccountId(source.getAccountId());
			info.setBankId(source.getBankId());
			info.setBic(source.getBic());
			info.setClosingBalance(source.getClosingBalance());
			info.setCurrency(source.getCurrency());
			info.setIban(source.getIban());
			info.setOpeningBalance(source.getOpeningBalance());
			info.setDateEnd(toLocalDate(source.getDateEnd()));
			info.setDateStart(toLocalDate(source.getDateStart()));
			info.setYearList(source.getYearList());
			info.setIdList(source.getIdList());
			info.setIdFrom(source.getIdFrom());
			info.setIdTo(source.getIdTo());
			info.setIdLastDownload(source.getIdLastDownload());
			return info;
		}
	}

	static class TransactionConverter implements Converter<TransactionList, List<FioTransaction>> {

		@Override
		public List<FioTransaction> convert(final TransactionList source) {
			if (source == null || source.getTransaction() == null) {
				return Collections.emptyList();
			}
			final List<FioTransaction> transactions = new ArrayList<>(source.getTransaction().size());
			for (Transaction transaction : source.getTransaction()) {
				final FioTransaction target = new FioTransaction();

				target.setTransactionId(transaction.getColumn22().getValue());
				target.setDate(toLocalDate(transaction.getColumn0().getValue()));
				target.setAmount(transaction.getColumn1().getValue());
				target.setType(transaction.getColumn8().getValue());
				target.setCurrency(transaction.getColumn14().getValue());

				if (transaction.getColumn2() != null) {
					target.setBankAccount(transaction.getColumn2().getValue());
				}
				if (transaction.getColumn3() != null) {
					target.setBankCode(transaction.getColumn3().getValue());
				}
				if (transaction.getColumn7() != null) {
					target.setUserId(transaction.getColumn7().getValue());
				}
				if (transaction.getColumn9() != null) {
					target.setOwner(transaction.getColumn9().getValue());
				}
				if (transaction.getColumn12() != null) {
					target.setBankName(transaction.getColumn12().getValue());
				}
				if (transaction.getColumn17() != null) {
					target.setRequestId(transaction.getColumn17().getValue());
				}
				if (transaction.getColumn25() != null) {
					target.setComment(transaction.getColumn25().getValue());
				}

				if (transaction.getColumn4() != null)
					target.setConstantSymbol(transaction.getColumn4().getValue());

				if (transaction.getColumn5() != null)
					target.setVariableSymbol(transaction.getColumn5().getValue());

				if (transaction.getColumn6() != null)
					target.setSpecificSymbol(transaction.getColumn6().getValue());

				transactions.add(target);
			}
			return transactions;
		}
	}

	private static LocalDate toLocalDate(final XMLGregorianCalendar date) {
		return date != null ? LocalDate.of(date.getYear(), date.getMonth(), date.getDay()) : null;
	}

}
