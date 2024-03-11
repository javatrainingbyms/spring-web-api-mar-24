package in.serosoft.utility;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class DAOUtil {
	public static void createProjection(Criteria criteria, Map<String, String> projections) {
		ProjectionList proList = Projections.projectionList();
		for (Map.Entry<String, String> entry : projections.entrySet()) {
			proList.add(Projections.property(entry.getKey()), entry.getValue());
		}
		criteria.setProjection(Projections.distinct(proList))
				.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
	}
	public static <C> void transformResultListToBeanClass(Criteria criteria, Map<String, String> projections,
			Class<C> beanClass) {

		ProjectionList proList = Projections.projectionList();
		for (Map.Entry<String, String> entry : projections.entrySet()) {
			proList.add(Projections.property(entry.getKey()), entry.getValue());
		}
		criteria.setProjection(Projections.distinct(proList)).setResultTransformer(Transformers.aliasToBean(beanClass));
	}
	public static Map<String, String> getProjectionInstance() {
		return new HashMap<String,String>();
	}
}
