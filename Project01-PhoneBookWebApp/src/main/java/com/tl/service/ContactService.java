package com.tl.service;

import java.util.List;

import com.tl.pojos.Contact;

public interface ContactService {
	public boolean saveContact(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContactByid(Integer cid);

	public boolean updateContact(Contact contact);

	public boolean deleteContactById(Integer cid);

}
