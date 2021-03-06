package com.champ.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.champ.core.entity.AppUser;
import com.champ.core.entity.AppUserTransaction;
import com.champ.core.entity.Bank;
import com.champ.data.access.services.ITransactionServiceDao;
import com.champ.gmail.api.dto.TransactionDTO;
import com.champ.services.IConverterService;
import com.champ.services.ITransactionService;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	ITransactionServiceDao transactionServiceDao;

	@Autowired
	IConverterService converterService;

	private static final Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

	public void saveUserTransactions(List<TransactionDTO> transactions, AppUser user, Bank bank) {
		if (transactions != null && transactions.size() > 0) {
			LOG.info("{} transactions found for user {}", transactions.size(), user.getMobile());
			for (TransactionDTO dto : transactions) {
				try {
					if (transactionServiceDao.checkUserTransaction(dto.getAmount(), dto.getDate(), dto.getSubMerchant(),
							user.getMobile())) {
						AppUserTransaction transaction = null;
						if (dto != null) {
							transaction = converterService.getTransactionFromDto(dto, user, bank);
						}
						if (transaction != null) {
							transactionServiceDao.saveUserTransaction(transaction);
							LOG.info("Transaction saved {} ", dto);
						} else {
							LOG.info("DTO received null for string {} and bank {}", dto.getPaymentModeString(),
									bank.getName());
						}
					} else {
						LOG.info("Transaction already exists {} ", dto);
					}
				} catch (Exception e) {
					LOG.error("Exception while saving transaction for user {}. Exception {}", user.getMobile(),
							e.getMessage());
				}
			}
		}
	}

	public boolean checkUserTransaction(Double amount, Date transactionDate, String submerchantCode, String mobile) {
		return transactionServiceDao.checkUserTransaction(amount, transactionDate, submerchantCode, mobile);
	}

	public List<AppUserTransaction> getUserTransactions(Long id) {
		return transactionServiceDao.getUserTransactions(id);
	}

	public AppUserTransaction getTransactionByUserId(Long userId, Long id) {
		return transactionServiceDao.getTransactionByUserId(userId, id);
	}

	public AppUserTransaction saveTransaction(AppUserTransaction transaction) {
		return transactionServiceDao.saveUserTransaction(transaction);
	}

	public List<AppUserTransaction> getUserCreatedTransactions(Long id) {
		return transactionServiceDao.getUserCreatedTransactions(id);
	}

}
