package com.champ.data.access.services;

import java.util.List;

import com.champ.core.entity.BankPaymentMode;

public interface IBankPaymentDao {

	public List<BankPaymentMode> getAllBankPaymentModes();

	public void saveOrUpdateBankPaymentMode(BankPaymentMode bankPaymentMode);

	public BankPaymentMode findBankPaymentModeById(Long id);

	public List<BankPaymentMode> findBankPaymentModesByBankId(Long id);
	
	public BankPaymentMode findPaymentModeByExtractedString(Long id, String extractedString);
}
