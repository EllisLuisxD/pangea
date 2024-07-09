package com.certus.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.certus.spring.Dao.ILoginDao;
import com.certus.spring.interfaces.ILoginRepository;
import com.certus.spring.models.Usuario;

@Repository
public class LoginRepository implements ILoginRepository {

	@Autowired
    private final ILoginDao loginDao;

    public LoginRepository(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }


	@Override
	public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return (Usuario) loginDao.findByUsername(username);
	}
}

