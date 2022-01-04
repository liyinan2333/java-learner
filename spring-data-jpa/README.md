### JPA命名规则

| Keyword           | Sample                          | JPQL                                                       |
| ----------------- | ------------------------------- | ---------------------------------------------------------- |
| And               | findByLastnameAndFirstname      | where x.lastname=?1 and x.firstname=?2                     |
| Or                | findByLastnameOrFirstname       | where x.lastname=?1 or x.firstname=?2                      |
| Between           | findByStartDateBetween          | where x.startDate between ?1 and ?2                        |
| LessThan          | findByAgeLessThan               | where x.startDate < ?1                                     |
| GreaterThan       | findByAgeGreaterThan            | where x.startDate >?1                                      |
| After             | findByStartDateAfter            | where x.startDate >n ?1                                    |
| Before            | findByStartDateBefore           | where x.startDate < ?1                                     |
| IsNull            | findByAgeIsNull                 | where x.age is null                                        |
| IsNotNull,NotNull | findByAge(Is)NotNull            | where x.age not null                                       |
| Like              | findByFirstnameLike             | where x.firstname like ?1                                  |
| notLike           | findByFirstnameNotLike          | where x.firstname not like ?1                              |
| StartingWith      | findByFirstnameStartingWithXXX  | where x.firstname like ?1(parameter bound with appended %) |
| EndingWith        | findByFirstnameEndingWithXXX    | where x.firstname like ?1(parameter bound with appended %) |
| Containing        | findByFirstnameContaining       | where x.firstname like ?1(parameter bound wrapped in %)    |
| OrderBy           | findByAgeOrderByLastname        | where x.age = ?1 order by x.lastname desc                  |
| Not               | findByLastnameNot               | where x.lastname <> ?1                                     |
| NotIn             | findByAgeNotIn(Collection age ) | where x.age not in ?1                                      |
| True              | findByActiveTrue()              | where x.active = true                                      |
| False             | findByActiveFalse()             | where x.active = false                                     |

