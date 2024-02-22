Command to start the spring boot web server containing the problem:

DD_IAST_ENABLED=true java -jar -javaagent:/link-to-the-dd-agent/dd-java-agent-1.30.1.jar /link-to-the-bootJar-file/repro-dd-iast-bug-1.0-SNAPSHOT.jar

After starting the server, an endpoint is accessible reproducing the bug when IAST is enabled. 

The endpoint is accessible locally via http://localhost:8080/bug

The error that results to this HTTP call is: 

```
a.w.r.e.AbstractErrorWebExceptionHandler : [0e51cea9-1]  500 Server Error for HTTP GET "/bug"
kotlin.reflect.jvm.internal.KotlinReflectionInternalError: Unresolved class: class me.chosante.SerializableByKotlinX$$serializer
at kotlin.reflect.jvm.internal.KClassImpl.reportUnresolvedClass(KClassImpl.kt:329) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
Suppressed: reactor.core.publisher.FluxOnAssembly$OnAssemblyException:
Error has been observed at the following site(s):
*__checkpoint ⇢ Handler me.chosante.Controller#get() [DispatcherHandler]
*__checkpoint ⇢ HTTP GET "/bug" [ExceptionHandlingWebHandler]
Original Stack Trace:
at kotlin.reflect.jvm.internal.KClassImpl.reportUnresolvedClass(KClassImpl.kt:329) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.jvm.internal.KClassImpl.access$reportUnresolvedClass(KClassImpl.kt:44) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.jvm.internal.KClassImpl$Data$descriptor$2.invoke(KClassImpl.kt:56) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.jvm.internal.KClassImpl$Data$descriptor$2.invoke(KClassImpl.kt:47) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal.invoke(ReflectProperties.java:92) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.jvm.internal.ReflectProperties$Val.getValue(ReflectProperties.java:31) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.jvm.internal.KClassImpl$Data.getDescriptor(KClassImpl.kt) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.jvm.internal.KClassImpl.getDescriptor(KClassImpl.kt:182) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at kotlin.reflect.full.KClasses.getCompanionObject(KClasses.kt:52) ~[kotlin-reflect-1.5.32.jar!/:1.5.32-release-578(1.5.32)]
at com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.hasCreatorAnnotation(KotlinNamesAnnotationIntrospector.kt:85) ~[jackson-module-kotlin-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.access$hasCreatorAnnotation(KotlinNamesAnnotationIntrospector.kt:30) ~[jackson-module-kotlin-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$2.invoke(KotlinNamesAnnotationIntrospector.kt:97) ~[jackson-module-kotlin-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$2.invoke(KotlinNamesAnnotationIntrospector.kt:97) ~[jackson-module-kotlin-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.module.kotlin.ReflectionCache.checkConstructorIsCreatorAnnotated(ReflectionCache.kt:99) ~[jackson-module-kotlin-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.hasCreatorAnnotation(KotlinNamesAnnotationIntrospector.kt:97) ~[jackson-module-kotlin-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.AnnotationIntrospector.findCreatorAnnotation(AnnotationIntrospector.java:1413) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair.findCreatorAnnotation(AnnotationIntrospectorPair.java:786) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair.findCreatorAnnotation(AnnotationIntrospectorPair.java:786) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector._addCreatorParam(POJOPropertiesCollector.java:722) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector._addCreatorParam(POJOPropertiesCollector.java:695) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector._addCreators(POJOPropertiesCollector.java:644) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector.collectAll(POJOPropertiesCollector.java:451) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector.getJsonValueAccessor(POJOPropertiesCollector.java:286) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.introspect.BasicBeanDescription.findJsonValueAccessor(BasicBeanDescription.java:258) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.ser.BasicSerializerFactory.findSerializerByAnnotations(BasicSerializerFactory.java:393) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.ser.BeanSerializerFactory._createSerializer2(BeanSerializerFactory.java:225) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.ser.BeanSerializerFactory.createSerializer(BeanSerializerFactory.java:174) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.SerializerProvider._createUntypedSerializer(SerializerProvider.java:1503) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.SerializerProvider._createAndCacheUntypedSerializer(SerializerProvider.java:1451) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.SerializerProvider._findExplicitUntypedSerializer(SerializerProvider.java:1420) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.hasSerializerFor(DefaultSerializerProvider.java:259) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at com.fasterxml.jackson.databind.ObjectMapper.canSerialize(ObjectMapper.java:3563) ~[jackson-databind-2.15.3.jar!/:2.15.3]
at org.springframework.http.codec.json.AbstractJackson2Encoder.canEncode(AbstractJackson2Encoder.java:131) ~[spring-web-6.0.16.jar!/:6.0.16]
at org.springframework.http.codec.EncoderHttpMessageWriter.canWrite(EncoderHttpMessageWriter.java:114) ~[spring-web-6.0.16.jar!/:6.0.16]
at org.springframework.web.reactive.result.method.annotation.AbstractMessageWriterResultHandler.getMediaTypesFor(AbstractMessageWriterResultHandler.java:228) ~[spring-webflux-6.0.16.jar!/:6.0.16]
at org.springframework.web.reactive.result.method.annotation.AbstractMessageWriterResultHandler.lambda$writeBody$0(AbstractMessageWriterResultHandler.java:164) ~[spring-webflux-6.0.16.jar!/:6.0.16]
at org.springframework.web.reactive.result.HandlerResultHandlerSupport.getProducibleTypes(HandlerResultHandlerSupport.java:190) ~[spring-webflux-6.0.16.jar!/:6.0.16]
at org.springframework.web.reactive.result.HandlerResultHandlerSupport.selectMediaType(HandlerResultHandlerSupport.java:141) ~[spring-webflux-6.0.16.jar!/:6.0.16]
at org.springframework.web.reactive.result.HandlerResultHandlerSupport.selectMediaType(HandlerResultHandlerSupport.java:121) ~[spring-webflux-6.0.16.jar!/:6.0.16]
at org.springframework.web.reactive.result.method.annotation.AbstractMessageWriterResultHandler.writeBody(AbstractMessageWriterResultHandler.java:164) ~[spring-webflux-6.0.16.jar!/:6.0.16]
at org.springframework.web.reactive.result.method.annotation.ResponseEntityResultHandler.lambda$handleResult$1(ResponseEntityResultHandler.java:190) ~[spring-webflux-6.0.16.jar!/:6.0.16]
...
```