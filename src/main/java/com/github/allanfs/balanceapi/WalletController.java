package com.github.allanfs.balanceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.balanceapi.domain.wallet.WalletService;
import com.github.allanfs.balanceapi.http.model.WalletHttp;
import com.github.allanfs.balanceapi.mappers.WalletMappers;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    
    @Autowired
    private WalletService walletService;
    
    @PostMapping
    public ResponseEntity<WalletHttp> createWallet(@RequestBody WalletHttp wallet) {
        walletService.createWallet(WalletMappers.INSTANCE.walletHttpToWallet(wallet));
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<WalletHttp>> getAllWallets() {
        return ResponseEntity.ok(WalletMappers.INSTANCE.walletsToWalletsHttp(walletService.getWallets()));
    }
}
