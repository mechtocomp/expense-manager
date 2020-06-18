package com.appsdeveloper.app.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appsdeveloper.app.ws.io.entity.AddExpenseEntity;
import com.appsdeveloper.app.ws.io.entity.UserEntity;
import com.appsdeveloper.app.ws.shared.dto.AmountByMonth;

@Repository
public interface ExpenseRepository extends JpaRepository<AddExpenseEntity, Integer>
{
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-01%'",nativeQuery = true)
//	public long janExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-02%'",nativeQuery = true)
//	public long febExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-03%'",nativeQuery = true)
//	public long marExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-04%'",nativeQuery = true)
//	public long aprExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-05%'",nativeQuery = true)
//	public long mayExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-06%'",nativeQuery = true)
//	public long junExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-07%'",nativeQuery = true)
//	public long julyExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-08%'",nativeQuery = true)
//	public long augExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-09%'",nativeQuery = true)
//	public long sepExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-10%'",nativeQuery = true)
//	public long octExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-11%'",nativeQuery = true)
//	public long novExpense();
//	
//	@Query (value = " select if (count(amount)>0, sum(amount),0) from expense_table where date LIKE '____-12%'",nativeQuery = true)
//	public long decExpense();
//	
	
	
	@Query (value=" SELECT sum(amount) as amount,MONTHNAME(date) as monthName,YEAR(date) as year\r\n" + 
			"FROM expense_table WHERE YEAR(date) = YEAR(date)\r\n" + 
			"GROUP BY YEAR(date),MONTH(date)",nativeQuery=true)
	public List<AmountByMonth> getAmount1();
	
	@Query(value = "SELECT new com.appsdeveloper.app.ws.shared.dto.AmountByMonth(month(t.date), year(t.date), sum(t.amount)) FROM expense_table t group by year(t.date), month(t.date)")
	public List<AmountByMonth> getAmount();
	
}
