(ns logic-as.core
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

(defrel can p1 p2)
(defrel must p1 p2)
(defrel ky1 bolig v)
(defrel kupon t sk k)
(fact kupon :ga3 :w "BBRabat")
(fact kupon :ga7 :w "OTTRabat")
(fact kupon :ga7 :k "OTTRabat")
(fact kupon :ga7 :f "OTTRabat")
(fact ky1 :p 1101401)
(fact ky1 :e 1101402)
(fact can :ga1 :ga2)
(fact can :ga1 :ga3)
(fact must :ga1 :ky1)
(fact can :ga2 :ta2)
(fact can :ga3 :ga4)
(fact can :ga3 :ga6)
(fact can :ga4 :ta4)
(fact can :ga6 :ta6)
(fact can :ga7 :ta7)
(fact can :ga1 :ga1)
(fact can nil :ga1)
(fact can nil :ga7)

(defn aso [har bolig sk]
  (let [har (cons nil har)]
    (set
     (run* [q]
           (conde [(fresh [x y z v]
                          (membero v har)
                          (can v x)
                          (must x y) 
                          (ky1 bolig z)
                          (== q [x y z]))]
                  [(fresh [x y z]
                          (membero z har)
                          (can z x)
                          (kupon x sk y)        
                          (== q [x y]))]
                  [(fresh [x y]
                          (membero y har)
                          (can y x)        
                          (== q [x]))])))))