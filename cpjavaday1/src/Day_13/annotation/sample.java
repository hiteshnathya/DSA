package Day_13.annotation;









//
//Annotations
//Are powerful feature that allows programers to provide metadata about their code.
//It provides hint to the compiler at runtime .
//Annotations can be applied to Classes, methods , Interfaces, variables and parameters.
//
//Annotations
//---------- Built In
//---------- Custom( Userdefined)
//
//BuiltIn (Use to provide hint to the compiler about the code.)
//Standard - @Override, @FunctionalInterface, @SupressWarnings.
//
//        MetaAnnotation( - @Target, @Inherited, @Documented.)
//@ Target -  @Target annotation is a meta-annotation, i.e., it can only be used to annotate other annotations. It takes ElementType enumeration as its only argument. ElementType enumeration is a constant which specifies the type of the program element declaration (class, interface, constructor, etc.) to which the annotation can be applied.
//
//Custom Annotation
//
//Define an Interface with @interface annotation
//It can be defined as methods with no paramaters and a return type.
