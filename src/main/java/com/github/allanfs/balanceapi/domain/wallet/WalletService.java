package com.github.allanfs.balanceapi.domain.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.balanceapi.database.repository.WalletRepository;
import com.github.allanfs.balanceapi.domain.model.Wallet;
import com.github.allanfs.balanceapi.mappers.WalletMappers;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(Wallet wallet) {
        com.github.allanfs.balanceapi.database.entity.WalletEntity walletEntity = new com.github.allanfs.balanceapi.database.entity.WalletEntity();
        walletEntity.setName(wallet.getName());
        walletEntity.setCreateDate(wallet.getCreateDate());
        return WalletMappers.INSTANCE.walletEntityToWallet(walletRepository.save(walletEntity));
    }

    public Iterable<Wallet> getWallets() {
        return WalletMappers.INSTANCE.walletsEntityToWallets(walletRepository.findAll())    ;
    }

    public void deleteWallet(long id) {
        walletRepository.deleteById(id);
    }

    public void updateWallet() {

    }

    public void getWallet(long id) {
        walletRepository.findById(id);
    }

    public void getWalletTransactions() {

    }

    public void getWalletBalance() {

    }

    public void getWalletBalanceByDate() {

    }

    public void getWalletBalanceByPeriod() {

    }
}
