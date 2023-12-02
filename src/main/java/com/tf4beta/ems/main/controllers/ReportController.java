package com.tf4beta.ems.main.controllers;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ReportController {

    @GetMapping("/generar-reporte")
    public ResponseEntity<byte[]> generarReporte() {
        try {
            // Cargar el archivo .jrxml desde resources
            InputStream inputStream = new ClassPathResource("ruta/a/tu/informe.jrxml").getInputStream();

            // Compilar el informe Jasper
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            // Crear parámetros si es necesario
            Map<String, Object> parametros = new HashMap<>();

            // Obtener el origen de datos (puede ser una lista, una base de datos, etc.)
            // Puedes adaptar esta parte según tus necesidades

            // Llenar el informe
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

            // Exportar a PDF
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            // Configurar la respuesta HTTP
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "informe.pdf");

            return ResponseEntity.ok().headers(headers).body(pdfBytes);
        } catch (Exception e) {
            // Manejar errores según tus necesidades
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
