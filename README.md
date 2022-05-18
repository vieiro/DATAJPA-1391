# DATAJPA-1391 Test Case

This is a test case for [DATAJPA-1391](https://github.com/spring-projects/spring-data-jpa/issues/1710)

It's a JPA project with three entities: A, B and AB.

AB has composite key with `@ManyToOne`, and JPA fails to persist
with `ConversionNotSupportedException`. The Entity can be persisted
using `EntityManager.persist()`, though.

## How to reproduce

```bash
$ mvn test
```

* The failed `save` operation is: [here]().
* The successful `persist` operation is [here]().


