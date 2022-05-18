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

* The failed `save` operation is: [here](https://github.com/vieiro/DATAJPA-1391/blob/b95c0ca4536a490b04d16edbe651126c3cafbc8a/src/test/java/com/example/datajpa1391/entities/EntityABTest.java#L75).
* The successful `persist` operation is [here](https://github.com/vieiro/DATAJPA-1391/blob/b95c0ca4536a490b04d16edbe651126c3cafbc8a/src/test/java/com/example/datajpa1391/entities/EntityABTest.java#L98).

## Workaround

As a workaround: use a primary key class with the column types and same name of entities.

* This EntityABPK composite primary key doesn't work: https://github.com/vieiro/DATAJPA-1391/blob/master/src/main/java/com/example/datajpa1391/entities/EntityABPK.java
* This EntityABPK composite primary key (branch `hotfix/1391) does work: https://github.com/vieiro/DATAJPA-1391/blob/hotfix/3391/src/main/java/com/example/datajpa1391/entities/EntityABPK.java

