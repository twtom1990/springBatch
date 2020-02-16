//package com.tom.batch.readFile1.reader;
//
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.stereotype.Component;
//
///**
// * Created with Tang Wei
// * Description:
// * User: SEELE
// * Date: 2020-02-16
// * Time: 18:07
// */
//@Component
//public class ReadFile1Reader<T> extends FlatFileItemReader<T> {
//    @Bean
//    public FlatFileItemReader<Person> csvItemReader() {
//        FlatFileItemReader<Person> csvItemReader = new FlatFileItemReader<>();
//        csvItemReader.setResource(new ClassPathResource("data/sample-data.csv"));
//        csvItemReader.setLineMapper(new DefaultLineMapper<Person>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[]{"name", "age"});
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                setTargetType(Person.class);
//            }});
//        }});
//        return csvItemReader;
//    }
//
//}
