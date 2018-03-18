//sharath 
package axela.inventory.controller;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import axela.config.Connect;
import axela.inventory.repository.InventoryBinItemFilterImp;
import axela.inventory.repository.InventoryFilterImp;
import axela.inventory.repository.InventoryStocklFilterImp;
import axela.inventory.repository.ItemOptionsFilterImpl;
import axela.inventory.service.ConfigureInventoryService;
import axela.inventory.service.Index;
import axela.inventory.service.InventoryBinItemService;
import axela.inventory.service.InventoryBinService;
import axela.inventory.service.InventoryCatService;
import axela.inventory.service.InventoryItemModelService;
import axela.inventory.service.InventoryItemOptionsService;
import axela.inventory.service.InventoryItemPriceService;
import axela.inventory.service.InventoryItemService;
import axela.inventory.service.InventoryLocationService;
import axela.inventory.service.InventoryReorderLevelService;
import axela.inventory.service.InventoryReportPriceBookService;
import axela.inventory.service.ReportCurrentStockService;
import axela.inventory.service.TaxService;
import axela.inventory.service.UOMeasurementService;

@RestController
@RequestMapping("/inventory")
@CrossOrigin("*")
// @Configurable
public class Controller_Inventory extends Connect {

	@Autowired(required = true)
	InventoryItemService inventoryItemService;
	@Autowired
	InventoryCatService inventoryCatService;
	@Autowired
	InventoryLocationService inventoryLocationService;
	@Autowired
	InventoryFilterImp inventoryFilterImp;
	@Autowired
	InventoryBinService inventoryBinService;
	@Autowired
	InventoryItemPriceService inventoryItemPriceService;
	@Autowired
	InventoryBinItemService inventoryBinItemService;
	@Autowired
	InventoryItemModelService inventoryItemModalService;
	@Autowired
	InventoryStocklFilterImp inventoryStocklFilterImp;
	@Autowired
	Index index;
	@Autowired
	InventoryReorderLevelService inventoryReorderLevelService;
	@Autowired
	InventoryReportPriceBookService inventoryReportPriceBookService;
	@Autowired
	ReportCurrentStockService reportCurrentStockService;
	@Autowired
	public UOMeasurementService uomeasurementService;
	@Autowired
	InventoryBinItemFilterImp inventoryBinItemFilterImp;
	@Autowired
	public TaxService taxService;
	@Autowired
	ConfigureInventoryService configureInventoryService;
	@Autowired
	InventoryItemOptionsService inventoryItemOptionsService;

	@Autowired
	ItemOptionsFilterImpl itemOptionsFilterImpl;
	@PostMapping("/item")
	public Map<String, String> Customer(@RequestBody String input, HttpSession session, HttpServletResponse response) throws Exception {
		return inventoryItemService.inventoryItemService(input, session, response);
	}

	@PostMapping("/item-config-details")
	public Map PopulateInventoryConfigDetails(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return inventoryItemService.populateInventoryConfigDetails(input, session, response);
	}

	@PostMapping("/item-data")
	public Map InventoryPopulateFields(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryItemService.inventoryPopulateFields(input, session, response);
	}
	@PostMapping("/inventory-config-details")
	public Map InventoryConfigDetails(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryLocationService.inventoryConfigDetails(input, session, response);
	}

	// To Get item List
	@PostMapping("/item-list")
	public Map ItemList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return inventoryItemService.listData(input, session);
	}

	@RequestMapping("/item-smartsearch")
	public Map itemSmartList() throws JSONException {
		return inventoryItemService.populateDrSmart();
	}

	// adding updating deleting category
	@PostMapping("/category")
	public Map ItemCategory(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryCatService.inventoryCategoryService(input, session, response);
	}

	@PostMapping("/category-data")
	public Map ItemCategoryPOpulateFields(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		System.out.println("category-list");
		return inventoryCatService.categoryPOpulateFields(input, session, response);
	}

	// To Get category List
	@PostMapping("/category-list")
	public Map listItemCategory(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return inventoryCatService.listData(input, session);
	}

	@RequestMapping("/category-smartsearch")
	public Map categorySmartList() throws JSONException {
		return inventoryCatService.populateDrSmart();
	}
	// location
	@PostMapping("/location")
	public Map Location(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryLocationService.inventoryLocationService(input, session, response);
	}

	@PostMapping("/location-data")
	public Map populateLocationFields(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryLocationService.locationPopulateFields(input, session, response);
	}

	@RequestMapping("/location-list")
	public Map LocationList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return inventoryLocationService.listData(input, session);
	}
	@RequestMapping("/location-smartsearch")
	public Map locationSmartList() throws JSONException {
		return inventoryLocationService.populateDrSmart();
	}
	// TO get Sales Cat List
	@PostMapping("/item-price")
	public Map itemPrice(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		System.out.println("coming----------");
		return inventoryItemPriceService.inventoryItemPriceService(input, session, response);
	}
	@PostMapping("/item-price-data")
	public Map itemPriceData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryItemPriceService.populateData(input, session);
	}
	@PostMapping("/item-price-list")
	public Map itemPriceList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		System.out.println("coming----------");
		return inventoryItemPriceService.listData(input, session);
	}
	@PostMapping("/itemName-data")
	public Map itemNameData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryItemPriceService.populateItemName(input, session);
	}
	// bin add/update/delete
	@PostMapping("/bin")
	public Map inventoryBinService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryBinService.inventoryBinService(input, session, response);
	}

	@PostMapping("/bin-data")
	public Map populateData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryBinService.populateField(input, session, response);
	}
	@PostMapping("/bin-list")
	public Map binList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return inventoryBinService.listData(input, session);
	}
	@RequestMapping("/bin-smartsearch")
	public Map binSmartList() throws JSONException {
		return inventoryBinService.populateDrSmart();
	}

	// bin-item
	@PostMapping("/bin-item")
	public Map inventoryBinItemService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryBinItemService.binItemService(input, session, response);
	}

	@PostMapping("/bin-item-data")
	public Map binPopulateData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryBinItemService.populateData(input, session);
	}

	@PostMapping("/bin-item-list")
	public Map binItemList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		System.out.println("coming----------");
		return inventoryBinItemService.listData(input, session);
	}

	@RequestMapping("/bin-item-smartsearch")
	public Map binItemSmartList() throws JSONException {
		return inventoryBinItemService.populateDrSmart();
	}

	// modal
	@PostMapping("/item-model")
	public Map itemModalService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryItemModalService.itemModelService(input, session, response);
	}
	@PostMapping("/item-model-data")
	public Map itemModalPopulateData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryItemModalService.populateData(input, session);
	}
	@PostMapping("/item-model-list")
	public Map itemModalList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		System.out.println("coming----------");
		return inventoryItemModalService.listData(input, session);
	}
	@RequestMapping("/item-model-smartsearch")
	public Map itemModalSmartList() throws JSONException {
		return inventoryItemModalService.populateDrSmart();
	}
	//
	// @PostMapping("/update")
	// public void update(@RequestBody String input, HttpSession session) throws JSONException {
	// System.out.println("coming----------");
	// String strSql = "Update AxelaInventoryCat cat set cat.catName='Mac1' where  cat.catId=1";
	// SOP("" + inventoryStocklFilterImp.updateQuery(strSql));
	// }

	// updateQuery

	@PostMapping("/updateQuery")
	public String updateQuery(@RequestBody String input, HttpSession session) throws JSONException {
		// System.out.println("coming----------");
		// SOP("aaaaaaaaaaaaaaaa" + inventoryStocklFilterImp.updateQuery(""));
		// inventoryStocklFilterImp.updateQueryChecking("");
		String strSearch = " invgroup.groupType = 1"
				+ " AND opt.optionGroupId = 3"

				+ " AND opt.optionItemmasterId = 2569";
		itemOptionsFilterImpl.updateOptionBasedOnGroupId(strSearch, 0);
		return "update executed";
	}
	@PostMapping("/inventory-dashboard")
	public Map inventoryIndex(@RequestBody String input, HttpSession session) throws JSONException {
		return index.ListReports(input, session);
	}
	@PostMapping("/report-pricebookdash")
	public Map pricebookdash(@RequestBody String input, HttpSession session, HttpServletRequest request) throws JSONException, ParseException {
		return inventoryReportPriceBookService.reportPriceBookService(input, session, request);
	}
	@PostMapping("/report-currentstock")
	public Map currentstockDash(@RequestBody String input, HttpSession session, HttpServletRequest request) throws JSONException, ParseException {
		return reportCurrentStockService.reportCurrentStockDash(input, session, request);
	}
	@PostMapping("/reorder-level")
	public Map reorderLevelService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryReorderLevelService.inventoryReorderLevelService(input, session, response);
	}

	@PostMapping("/reorder-level-data")
	public Map reorderLevelData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryReorderLevelService.populateData(input, session);
	}
	@PostMapping("/reorder-level-list")
	public Map reorderLevelList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryReorderLevelService.listData(input, session);
	}
	@PostMapping("/reorder-level-smartsearch")
	public Map reorderlevelSmartList() throws JSONException {
		return inventoryReorderLevelService.populateDrSmart();
	}
	@PostMapping("/uom")
	public Map<String, String> uom(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return uomeasurementService.uoMeasurementService(input, session, response);
	}

	@PostMapping("/uom-data")
	public Map uomData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return uomeasurementService.populateData(input, session, response);
	}

	@PostMapping("/uom-list")
	public Map uomList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return uomeasurementService.listData(input, session);
	}

	@RequestMapping("/uom-smartsearch")
	public Map opportunitySmartSearch(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {
		return uomeasurementService.populateDrSmart();
	}

	@PostMapping("/tax")
	public Map taxService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return taxService.taxService(input, session, response);
	}

	@PostMapping("/tax-data")
	public Map taxData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return taxService.populateData(input, session);
	}

	@PostMapping("/tax-list")
	public Map taxList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return taxService.listData(input, session);
	}

	@PostMapping("/tax-smartsearch")
	public Map taxSmartList() throws JSONException {
		return taxService.populateDrSmart();
	}

	@PostMapping("/inventory-configuration")
	public Map inventoryConfigurationService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return configureInventoryService.configureInventoryService(input, session, response);
	}

	@PostMapping("/inventory-configuration-data")
	public Map inventoryPopulateData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return configureInventoryService.populateData(input, session);
	}

	@PostMapping("/item-option")
	public Map itemOptionService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryItemOptionsService.itemOptionsService(input, session, response);
	}

	@PostMapping("/item-option-data")
	public Map itemOptionData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return inventoryItemOptionsService.populateData(input, session);
	}

	@PostMapping("/item-option-list")
	public Map itemOptionList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return inventoryItemOptionsService.populateConfigureProductListData(input, session);
	}
}
