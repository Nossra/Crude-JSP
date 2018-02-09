package utilities;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface PredicateBuilder<T> {
	Predicate builder(CriteriaBuilder cb, Root<T> root);
}
