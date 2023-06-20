package br.com.jlgregorio.mybooks.repository;

import br.com.jlgregorio.mybooks.model.AuthorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Integer> {

    public Page<AuthorModel> findAll(Pageable pageable);

    //..query methods
    public Page<AuthorModel> findByNameStartsWithIgnoreCaseOrderByName(Pageable pageable, String name);

}
