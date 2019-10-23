/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bitsofts.springwithhibernate.service;

import io.bitsofts.springwithhibernate.model.Product;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

/**
 *
 * @author Administrator
 */
@Component(value = "exportProducts")
public class ReportHtmlView extends AbstractView{
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        response.setContentType("text/html");
        List<Product> products = (List<Product>) model.get("products");
        //data source
        JRDataSource dataSource = getDataSource(products);
        //compile jrxml template and get report
        JasperReport report = getReport();
        //fill the report with data source objects
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, dataSource);
        //export to html
        HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
        exporter.exportReport();
    }
    private JRDataSource getDataSource(List<Product> products) {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
        return dataSource;
    }
    
    public JasperReport getReport() throws JRException{
        InputStream stream = getClass().getResourceAsStream("/products.jrxml");
        return JasperCompileManager.compileReport(stream);
    }
    
}
