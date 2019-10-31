package com.sid.service.impl;

import com.sid.mapper.lee.ExpenditureMapper;
import com.sid.mapper.sid.AccountMapper;
import com.sid.model.lee.Expenditure;
import com.sid.model.sid.Account;
import com.sid.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private ExpenditureMapper expenditureMapper;

    @Override
    @Transactional
    public String testJtaAtomikos() {
        Account account = new Account();
        account.setAccountBalance(560.56f);
        accountMapper.insertSelective(account);

        Expenditure expenditure = new Expenditure();
        expenditure.setMoney(3.3f);
        expenditureMapper.insertSelective(expenditure);
        int i = 1 / 0;
        return "done";
    }
}