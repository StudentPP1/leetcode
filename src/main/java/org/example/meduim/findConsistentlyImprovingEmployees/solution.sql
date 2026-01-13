with selected_employees as (select employee_id
                            from performance_reviews
                            group by employee_id
                            having count(review_id) >= 3),
     rating_table as (select pr.employee_id,
                             e.name,
                             pr.review_date,
                             pr.rating,
                             nth_value(rating, 3)
                             over (partition by pr.employee_id order by pr.review_date desc) as first,
                             nth_value(rating, 2)
                             over (partition by pr.employee_id order by pr.review_date desc) as second,
                             nth_value(rating, 1)
                             over (partition by pr.employee_id order by pr.review_date desc) as third
                      from performance_reviews as pr
                               join employees e using (employee_id)
                               join selected_employees using (employee_id)
                      order by pr.employee_id, pr.review_date desc)
select distinct employee_id, name, third - first as improvement_score
from rating_table
where third > second
  and second > first
  and third > first
order by improvement_score desc, name;