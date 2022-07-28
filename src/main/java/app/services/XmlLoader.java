package app.services;

import app.model.ZregDoc;
import app.model.ZregDocsBasedc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.stereotype.Component;

@Component
public class XmlLoader {

//	private final EntityManagerFactory entityManagerFactory;
	private final ZregDocRepo zregDocRepo;

	public XmlLoader(
//			EntityManagerFactory entityManagerFactory,
			ZregDocRepo zregDocRepo
	) {
//		this.entityManagerFactory = entityManagerFactory;
		this.zregDocRepo = zregDocRepo;
	}

	@PostConstruct
	public void load() {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();

		//СОХРАНЕНИЕ ВСЕХ ПО ОЧЕРЕДИ НО В ОДНОЙ ТРНЗАКЦИИ
//		try {
//			long start = System.currentTimeMillis();
//			entityTransaction.begin();
//
//			for (int i = 0; i < 100; i++) {
//				ZregDocsBasedc zregDocsBasedc = new ZregDocsBasedc();
//				Set<ZregDocsBasedc> zregDocsBasedcSet = new HashSet<>();
//				zregDocsBasedcSet.add(zregDocsBasedc.fillFields());
//				ZregDoc zregDoc = new ZregDoc();
//				zregDoc = zregDoc.fillFields(zregDocsBasedcSet);
//				entityManager.persist(zregDoc);
//			}
//			entityTransaction.commit();
//			System.out.println("\nRESULT TIME = " + (System.currentTimeMillis() - start) + " ms\n");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


		//СОХРАНЕНИЕ ВСЕХ ОДНИМ ПАКЕТОМ
		List<ZregDoc> list = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
				ZregDocsBasedc zregDocsBasedc = new ZregDocsBasedc();
				Set<ZregDocsBasedc> zregDocsBasedcSet = new HashSet<>();
				zregDocsBasedcSet.add(zregDocsBasedc.fillFields());
				ZregDoc zregDoc = new ZregDoc();
				zregDoc = zregDoc.fillFields(zregDocsBasedcSet);
				list.add(zregDoc);
			}
		if (!list.isEmpty()) {
			zregDocRepo.saveAll(list);
		}
		System.out.println("\nRESULT TIME = " + (System.currentTimeMillis() - start) + " ms\n");
	}
}