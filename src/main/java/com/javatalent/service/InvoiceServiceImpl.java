package com.javatalent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatalent.entity.Invoice;
import com.javatalent.exceptions.InvoiceNotFoundException;
import com.javatalent.repo.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

	@Autowired
	private InvoiceRepository repo;

	@Override
	public Invoice saveInvoice(Invoice invoice) {
		return repo.save(invoice);
	}

	@Override
	public List<Invoice> getAllInvoices() {
		return repo.findAll();
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		Optional<Invoice> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new InvoiceNotFoundException("Invoice with Id : " + id + " Not Found");
		}
	}

	@Override
	public void deleteInvoiceById(Long id) {
		repo.delete(getInvoiceById(id));
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		repo.save(invoice);
	}

}
