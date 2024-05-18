package com.javatalent.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatalent.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
