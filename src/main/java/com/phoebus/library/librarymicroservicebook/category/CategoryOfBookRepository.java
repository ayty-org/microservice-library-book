package com.phoebus.library.librarymicroservicebook.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryOfBookRepository extends JpaRepository<CategoryOfBook,Long> {
}
