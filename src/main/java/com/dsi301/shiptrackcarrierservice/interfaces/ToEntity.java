package com.dsi301.shiptrackcarrierservice.interfaces;

public interface ToEntity<T,K> {
    T toEntity(K k);
}
