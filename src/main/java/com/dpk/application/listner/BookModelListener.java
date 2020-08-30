package com.dpk.application.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import com.dpk.application.model.Book;
import com.dpk.application.service.SequenceGeneratorService;

public class BookModelListener extends AbstractMongoEventListener<Book> {

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Book> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
		}
	}
}
