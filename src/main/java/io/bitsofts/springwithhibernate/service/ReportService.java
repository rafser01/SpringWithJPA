/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bitsofts.springwithhibernate.service;

import io.bitsofts.springwithhibernate.repository.ProductRepository;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class ReportService {
    
    @Autowired
    private ProductRepository pr;
    public String generateReport(){
        try {
            String reportPath = "F:\\Content\\Report";
            // compile report .jrxml to .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            // add datadource
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource((Collection<?>) pr.findAll());
            // to add parameter, creating map
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title", "This is title");
            // Fill the report
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            // export to pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, "report.pdf");
            System.out.println("Printed -------------- Exported ");
            return "Report successfully generated ";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
    
    
}
