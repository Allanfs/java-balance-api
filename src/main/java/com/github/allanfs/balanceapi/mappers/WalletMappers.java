package com.github.allanfs.balanceapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.github.allanfs.balanceapi.database.entity.WalletEntity;
import com.github.allanfs.balanceapi.domain.model.Wallet;
import com.github.allanfs.balanceapi.http.model.WalletHttp;

@Mapper
public interface WalletMappers {

    WalletMappers INSTANCE = Mappers.getMapper(WalletMappers.class);

    Wallet walletEntityToWallet(WalletEntity walletEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "transactions", ignore = true)
    Wallet walletHttpToWallet(WalletHttp walletHttp);

    Iterable<WalletHttp> walletsToWalletsHttp(Iterable<Wallet> wallets);
    Iterable<Wallet> walletsEntityToWallets(Iterable<WalletEntity> wallets);

}
