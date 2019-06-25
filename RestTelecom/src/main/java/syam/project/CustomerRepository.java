package syam.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.PageRanges;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Page<List<Customer>> findByNameContaining(String text, Pageable pageable);
    Page<List<Customer>> findByNameContainingOrIdentityNumberContaining(String text1, String text2, Pageable pageable);
    Page<List<Customer>> findByJoinedDateBetween(String text1, String text2, Pageable pageable);

}






