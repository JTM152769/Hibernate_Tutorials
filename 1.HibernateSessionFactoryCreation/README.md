# SessionFactory
A thread-safe (and immutable) representation of the mapping of the application domain model to a database. Acts as a factory
for org.hibernate.Session instances. The EntityManagerFactory is the JPA equivalent of a SessionFactory and
basically, those two converge into the same SessionFactory implementation.
A SessionFactory is very expensive to create, so, for any given database, the application should have only one associated
SessionFactory . The SessionFactory maintains services that Hibernate uses across all Session(s) such as second level
caches, connection pools, transaction system integrations, etc.

# Session
A single-threaded, short-lived object conceptually modeling a "Unit of Work" PoEAA. In JPA nomenclature, the Session is
represented by an EntityManager .
Behind the scenes, the Hibernate Session wraps a JDBC java.sql.Connection and acts as a factory for
org.hibernate.Transaction instances. It maintains a generally "repeatable read" persistence context (first level cache) of
the application domain model.
