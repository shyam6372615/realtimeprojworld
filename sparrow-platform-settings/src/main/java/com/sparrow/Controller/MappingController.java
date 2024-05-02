//package com.sparrow.Controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sparrow.service.MappingService;
//
//@RequestMapping("/sparrow")
//@RestController
//@CrossOrigin
//public class MappingController {
//	@Autowired
//private MappingService mappingService;
//	@GetMapping("/data/{instituteId}")
//    public ResponseEntity<Map<String, Object>> getAllData(@PathVariable("instituteId") Long instituteId) {
//        Map<String, Object> responseData = new HashMap<>();
//        responseData.put("activeModuleData", mappingService.getAllActiveModule(instituteId));
//        responseData.put("allModuleData", mappingService.getAllModule());
//        return ResponseEntity.ok(responseData);
//    }
//}
//@GetMapping("/data/{instituteId}")
//    public ResponseEntity<Map<String, Object>> getAllData(@PathVariable("instituteId") Long instituteId) {
//        Map<String, Object> responseData = new HashMap<>();
//        responseData.put("activeModuleData", mappingService.getAllActiveModule(instituteId));
//        responseData.put("allModuleData", mappingService.getAllModule());
//        return ResponseEntity.ok(responseData);
//    }
//}
