package com.digivisions.assessment.managingfiles.entity;

import javax.persistence.*;


@Entity
@Table(name = "files")
public class Files extends BaseEntity {

    @Column(name = "\"binary\"")
    private byte[] binary;

    @JoinColumn(name = "item_id")
    @ManyToOne
    private Item item;

    public byte[] getBinary() {
        return binary;
    }

    public void setBinary(byte[] binary) {
        this.binary = binary;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
