package cz.geek.fio;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class FioTransaction {

	private String transactionId;
	private LocalDate date;
	private BigDecimal amount;
	private String currency;
	private String bankAccount;
	private String bankCode;
	private String bankName;
	private String userId;
	private String type;
	private String owner;
	private String comment;
	private long requestId;
	private String variableSymbol;
	private String constantSymbol;
	private String specificSymbol;

}
