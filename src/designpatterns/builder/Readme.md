# why the hell i need this if 0 arg constructor and setter is already possible?
    Person p = new Person();
    p.setName("prem");

    Person p = new PersonBuilder().setName("prem").build();



# Advantages
- validation on build to check error on inputs before creating instance
- immutability, you can modify before creation in builder but can't after it. But zero arg constructor with setter method are immutable
- prevents telescopic constructor problem, by passing builder as only argument to constructor
# DisAdvantages
duplicate fields