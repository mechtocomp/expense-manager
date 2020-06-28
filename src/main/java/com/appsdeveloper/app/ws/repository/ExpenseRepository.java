package com.appsdeveloper.app.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appsdeveloper.app.ws.io.entity.AddExpenseEntity;
import com.appsdeveloper.app.ws.shared.dto.AmountByMonth;

@Repository
public interface ExpenseRepository extends JpaRepository<AddExpenseEntity, Integer>
{
	
	@Query(value = "SELECT new com.appsdeveloper.app.ws.shared.dto.AmountByMonth(monthname(t.date) as monthName, year(t.date) as year, sum(t.amount) as amount) FROM expense t where (t.user.id=?1) group by year(t.date), month(t.date) order by year(t.date), month(t.date)")
	List<AmountByMonth> getAmount(Integer id);
	
	@Query(value = "SELECT sum(amount) FROM expense where user_id=?",  nativeQuery = true)
	int getExpenditure(Integer id);
	
	@Query(value = "SELECT * FROM expense u WHERE u.user_id = ?",  nativeQuery = true)
	List<AddExpenseEntity> getAllExpense(Integer id);

}
