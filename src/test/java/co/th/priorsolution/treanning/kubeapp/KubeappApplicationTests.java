package co.th.priorsolution.treanning.kubeapp;

import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.model.ResponseModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.*;
import co.th.priorsolution.treanning.kubeapp.reprository.*;
import co.th.priorsolution.treanning.kubeapp.service.AdventureService;
import co.th.priorsolution.treanning.kubeapp.service.MarketplaceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;

@Slf4j
class KubeappApplicationTests {
	@Mock
	private AdventureRepository adventureRepository;

//	@Mock
//	private NotificationRepository notificationRepository;
//
	@InjectMocks
	private AdventureService adventureService;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
//

	//test Adventure service

		@Test
		public  void test_createAdventure_expect_ResponseModel_eq_201() {
			AdventureRepository adventureRepository = new AdventureReprositoryTest();
			AdventureService adventureService = new AdventureService(adventureRepository);
			AdventureModel adventureModel = new AdventureModel();
			adventureModel.setName("xx");
			adventureModel.setEmail("yy");
			adventureModel.setBalance(500);
			ResponseModel<Void> result = adventureService.createAdventure(adventureModel);
			assertTrue(result.getStatus()==201);

		}

		@Test
	public  void  test_createAdventure_expect_ResponseModel_eq_500(){
			AdventureRepository adventureRepository = new AdventureReorositoryTest_Case500();
			AdventureService adventureService = new AdventureService(adventureRepository);
			AdventureModel adventureModel = new AdventureModel();
			adventureModel.setName("xx");
			adventureModel.setEmail("yy");
			adventureModel.setBalance(500);
			try {
			ResponseModel<Void> result =  adventureService.createAdventure(adventureModel);
				//log.info("log result {}",result);

			} catch (Exception e){
				log.info("log result {}",e.getMessage());
				Assertions.assertTrue(null != e.getMessage());

			}

		}



		//test marketplace service post item

@Test
	public  void test_postItem_expect_ResponseModel_eq_201(){
		MarketplaceRepository marketplaceRepository = new MarketplaceServiceTest_Case201();
		NotificationRepository notificationRepository = new NotificationServiceTest_Case201();


		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository,null, null, notificationRepository, null );

		MarketplaceModel marketplaceModel = new MarketplaceModel();
		marketplaceModel.setItemId(1);
		marketplaceModel.setPrice(100);
		marketplaceModel.setSellerId(2);
		ResponseModel<Void> result = marketplaceService.postItem(marketplaceModel);
		assertTrue(result.getStatus()==201);
	}


	@Test

	public void test_postItem_expect_ResponseModel_eq_500(){
		MarketplaceRepository marketplaceRepository = new MarketplaceServiceTest_Case500();
		NotificationRepository notificationRepository = new NotificationServiceTest_Case500();


		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository,null, null, notificationRepository, null );

		MarketplaceModel marketplaceModel = new MarketplaceModel();
		marketplaceModel.setItemId(1);
		marketplaceModel.setPrice(100);
		marketplaceModel.setSellerId(2);

		try {
			ResponseModel<Void> result = marketplaceService.postItem(marketplaceModel);
		log.info("log Result: {}",result);

		}catch (Exception e){
			log.info("log Result: {}",e.getMessage());
			Assertions.assertTrue(null != e.getMessage());


		}


	}


	// buy item

	@Test
	public  void test_buyItem_expect_ResponseModel_eq_200(){
		MarketplaceRepository marketplaceRepository = new MarketplaceServiceTest_Case201();
		NotificationRepository notificationRepository = new NotificationServiceTest_Case201();
		AdventureRepository adventureRepository = new AdventureReprositoryTest();
		ItemRepository itemRepository = new ItemServiceTest_Case201();
		HistoryRepository historyRepository = new HistoryServiceTest_Case201();
		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository,adventureRepository, itemRepository, notificationRepository, historyRepository );
		MarketplaceModel marketplaceModel = new MarketplaceModel();

	    marketplaceModel.setId(2);
	    marketplaceModel.setBuyerId(1);

		ResponseModel<Void> result = marketplaceService.buyItem(marketplaceModel);
		log.info("Result {}",result );
		assertTrue(result.getStatus()==200);
	}


	@Test
	public  void test_buyItem_expect_ResponseModel_eq_400(){
		MarketplaceRepository marketplaceRepository = new MarketplaceServiceTest_Case400();
		NotificationRepository notificationRepository = new NotificationServiceTest_Case201();
		AdventureRepository adventureRepository = new AdventureReorositoryTest_Case400();
		ItemRepository itemRepository = new ItemServiceTest_Case201();
		HistoryRepository historyRepository = new HistoryServiceTest_Case201();
		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository,adventureRepository, itemRepository, notificationRepository, historyRepository );
		MarketplaceModel marketplaceModel = new MarketplaceModel();

		marketplaceModel.setId(2);
		marketplaceModel.setBuyerId(1);

		ResponseModel<Void> result = marketplaceService.buyItem(marketplaceModel);
		log.info("Result {}",result );
		assertTrue(result.getStatus()==400);
	}
	@Test
	public  void test_buyItem_expect_ResponseModel_eq_404(){
		MarketplaceRepository marketplaceRepository = new MarketplaceServiceTest_Case404();
		NotificationRepository notificationRepository = new NotificationServiceTest_Case201();
		AdventureRepository adventureRepository = new AdventureReprositoryTest();
		ItemRepository itemRepository = new ItemServiceTest_Case201();
		HistoryRepository historyRepository = new HistoryServiceTest_Case201();
		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository,adventureRepository, itemRepository, notificationRepository, historyRepository );
		MarketplaceModel marketplaceModel = new MarketplaceModel();

		marketplaceModel.setId(2);
		marketplaceModel.setBuyerId(1);

		ResponseModel<Void> result = marketplaceService.buyItem(marketplaceModel);
		log.info("Result {}",result );
		assertTrue(result.getStatus()==404);
	}

	@Test
	public  void test_buyItem_expect_ResponseModel_eq_500(){
		MarketplaceRepository marketplaceRepository = new MarketplaceServiceTest_Case500();
		NotificationRepository notificationRepository = new NotificationServiceTest_Case201();
		AdventureRepository adventureRepository = new AdventureReprositoryTest();
		ItemRepository itemRepository = new ItemServiceTest_Case201();
		HistoryRepository historyRepository = new HistoryServiceTest_Case201();
		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository,adventureRepository, itemRepository, notificationRepository, historyRepository );
		MarketplaceModel marketplaceModel = new MarketplaceModel();
		marketplaceModel.setId(2);
		marketplaceModel.setBuyerId(1);
		try {
			ResponseModel<Void> result = marketplaceService.buyItem(marketplaceModel);
			log.info("log result {}",result);

		}catch (Exception e){
			log.info("error {}",e.getMessage() );
			Assertions.assertTrue(null != e.getMessage());

		}




	}





	@Test
	public  void test_createAdventure_Mock_expect_ResponseModel_eq_201(){
			AdventureRepository adventureRepository1 = Mockito.mock(AdventureRepository.class);
		// Arrange
		AdventureModel adventureModel = new AdventureModel();
		adventureModel.setName("xx");
		adventureModel.setEmail("yy");
		adventureModel.setBalance(500);
		// Act
		Mockito.when(adventureRepository1.createAdventure(adventureModel)).thenReturn(1);
		ResponseModel<Void> responseModel = adventureService.createAdventure(adventureModel);

		// Assert
		assertEquals(201, responseModel.getStatus());
		assertEquals("created Adventure successfully", responseModel.getDescription());


	}






}
