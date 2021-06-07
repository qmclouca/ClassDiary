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

import com.rlb.backend.classdiary.dto.UserDTO;
import com.rlb.backend.classdiary.entities.User;
import com.rlb.backend.classdiary.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest){
		Page<User> list = repository.findAll(pageRequest); 
		return list.map(x -> new UserDTO(x));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found - Entidade não encontrada."));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		entity.setName(dto.getName());
		entity.setRole(dto.getRole());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional	
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getOne(id); // usar para atualizar o banco de dados
			entity.setName(dto.getName());
			entity.setRole(dto.getRole());
			entity = repository.save(entity);
			return new UserDTO(entity);
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
