# Hibernate Relationships Playground

This project is a learning-focused Spring Boot + Hibernate application
that demonstrates correct usage of:

- @OneToOne (owning side, orphanRemoval, cascade)
- @ManyToOne / @OneToMany (FK ownership rules)
- @ManyToMany (join table behavior)

The project uses PostgreSQL and SQL logging to observe
the exact queries Hibernate generates.

No controllers or UI — focused purely on ORM behavior.
