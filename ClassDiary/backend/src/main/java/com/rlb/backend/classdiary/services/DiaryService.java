package com.rlb.backend.classdiary.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.web.client.ResourceAccessException;

import com.rlb.backend.classdiary.dto.DiaryDTO;
import com.rlb.backend.classdiary.dto.UserDTO;
import com.rlb.backend.classdiary.entities.Diary;
import com.rlb.backend.classdiary.entities.User;
import com.rlb.backend.classdiary.repositories.DiaryRepository;

@Service
public class DiaryService {
	@Autowired
	private DiaryRepository repository;
	@Transactional(readOnly = true)
	public Page<DiaryDTO> findAllPaged(PageRequest pageRequest){
		Page<Diary> list = repository.findAll(pageRequest); 
		return list.map(x -> new DiaryDTO(x));
	}

	@Transactional(readOnly = true)
	public DiaryDTO findById(Long id) {
		Optional<Diary> obj = repository.findById(id);
		Diary entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found - Entidade não encontrada."));
		return new DiaryDTO(entity);
	}
	
	@Transactional
	public DiaryDTO insert(DiaryDTO dto) {
		Diary entity = new Diary();
		entity.setBimester(dto.getBimester());
		entity.setStudant(dto.getStudant());
		entity.setAvaluation(dto.getAvaluation());
		entity.setClassroomParticipation(dto.getClassroomParticipation());
		entity.setDeliveryOfTasks(dto.getDeliveryOfTasks());
		entity.setBimonthlyWork(dto.getBimonthlyWork());
		entity.setBimonthlyTest(dto.getBimonthlyTest());
		entity.setBimonthlyPeriod(dto.getBimonthlyPeriod());
		entity.setPresenceInTheClasses(dto.getPresenceInTheClasses());
		entity = repository.save(entity);
		return new DiaryDTO(entity);
	}

	@Transactional	
	public DiaryDTO update(Long id, DiaryDTO dto) {
		try {
			Diary entity = repository.getOne(id); // usar para atualizar o banco de dados
			entity.setBimester(dto.getBimester());
			entity.setStudant(dto.getStudant());
			entity.setAvaluation(dto.getAvaluation());
			entity.setClassroomParticipation(dto.getClassroomParticipation());
			entity.setDeliveryOfTasks(dto.getDeliveryOfTasks());
			entity.setBimonthlyWork(dto.getBimonthlyWork());
			entity.setBimonthlyTest(dto.getBimonthlyTest());
			entity.setBimonthlyPeriod(dto.getBimonthlyPeriod());
			entity.setPresenceInTheClasses(dto.getPresenceInTheClasses());
			entity = repository.save(entity);
			return new DiaryDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceAccessException("Id not found" + id);
		}

	}

	public void delete(Long id) throws BindException {
		try {
		repository.deleteById(id);
	}
		catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new BindException("Database integrity violation", null);
		}
	}
}
