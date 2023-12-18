package com.projects.ruleengine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TRAN")
public class Tran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TRANSACTION")
    @Column(name = "TRAN_ID")
    private Long tranId;

    @Column(name = "TRAN_NAME")
    private String tranName;

    @Column(name = "TRAN_TYPE")
    private String tranType;

    @Column(name = "TRAN_AMOUNT")
    private String tranAmount;

    @Column(name = "TRAN_DATE")
    private String tranDate;

    @Column(name = "TRAN_TIME")
    private String tranTime;

    @Column(name = "TRAN_STATUS")
    private String tranStatus;

    @Column(name = "TRAN_DESCRIPTION")
    private String tranDescription;

    @Column(name = "TRAN_CATEGORY")
    private String tranCategory;

    @Column(name = "TRAN_CURRENCY")
    private String tranCurrency;

}