# CANDIDATE CLASS
1. This is the candidate complete candidate class for the pool project
```mermaid
classDiagram
    class Candidate
    Candidate : +String firstname
    Candidate : +String lastname
    Candidate : +String email
    Candidate : +Picture picture
    
    class CandidateController
    CandidateController : +getAllCandidate()
    CandidateController : +createCandidate(Candidate candidate)
    CandidateController : +removeCandidate(Candidate candidate)
    CandidateController : +modifyCandidat(Candidate candidate)
    
    class CandidateServices
    CandidateServices : +findAll()
    CandidateServices: +findById(int id)
    CandidateServices: +save(Candodate candidate)
    CandidateServices: +delete(Candidate candidate)
    CandidateServices: +update(Candidate candidate)

    class CrudRepository
    <<interface>> CrudRepository
    CrudRepository : +findAll()
    CrudRepository: +findById(int id)
    CrudRepository: +save(Candodate candidate)
    CrudRepository: +delete(Candidate candidate)
    CrudRepository: +update(Candidate candidate)
    
    class CandidateRepository
    CandidateRepository : +findAll()
    CandidateRepository: +findById(int id)
    CandidateRepository: +save(Candodate candidate)
    CandidateRepository: +delete(Candidate candidate)
    CandidateRepository: +update(Candidate candidate)
    
```
# OBSERVER CLASS
- It's the complete Observer class for project
```mermaid
classDiagram
    class observer
    observer : +int id
    observer : +String lastname
    observer : +String firstname
    observer : +String society
    observer : +String email
    
    class ObserverController
    ObserverController: +createObserver(Observer observer)
    ObserverController: +getObserverById(int id)
    ObserverController: +getAllObserver()
    ObserverController: +updateObserver(int id, Observer observer)
    ObserverController: +deleteObserver(int id)
    
    class ObserverService
    ObserverService: +createObserver(Observer observer)
    ObserverService: +getObserverById(int id)
    ObserverService: +getAllObserver()
    ObserverService: +updateObserver(int id, Observer observer)
    ObserverService: +deleteObserver(int id)

    class ObserverRepository
    ObserverRepository : +findAll()
    ObserverRepository: +findById(int id)
    ObserverRepository: +save(Candodate candidate)
    ObserverRepository: +delete(Candidate candidate)
    ObserverRepository: +update(Candidate candidate)

    class CrudRepository
    <<interface>> CrudRepository
    CrudRepository : +findAll()
    CrudRepository: +findById(int id)
    CrudRepository: +save(Candodate candidate)
    CrudRepository: +delete(Candidate candidate)
    CrudRepository: +update(Candidate candidate)

```
# Pools class
```mermaid

classDiagram
class pools
pools : +int id
pools : +String name
pools  : +String town
pools  : +Date date

    class PoolsController
    PoolsController : +createPool()
    PoolsController : +getPools()
    PoolsController : +getPoolsById(id)
    PoolsController : +updatePool(Pools, pool)
    PoolsController : +deletePool(id)
    
    class poolsServices
    poolsServices : +createPool(Pools pool)
    poolsServices: +getPoolsById(int id)
    poolsServices: +getPools()
    poolsServices: +delete(pool)
    poolsServices: +update(pools pool)
    
    class poolsRepository
    <<interface>> poolsRepository
    poolsRepository : extends CrudRepository
```