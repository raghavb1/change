package com.champ.base.response;

import java.util.List;

public class GetUserTransactionResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2265505431527477686L;

	private List<UserTransaction> userTransactions;

	public List<UserTransaction> getUserTransactions() {
		return userTransactions;
	}

	public void setUserTransactions(List<UserTransaction> userTransactions) {
		this.userTransactions = userTransactions;
	}

}
