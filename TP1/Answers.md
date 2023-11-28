# Practical Session #1: Introduction

1. Find in news sources a general public article reporting the discovery of a software bug. Describe the bug. If possible, say whether the bug is local or global and describe the failure that manifested its presence. Explain the repercussions of the bug for clients/consumers and the company or entity behind the faulty program. Speculate whether, in your opinion, testing the right scenario would have helped to discover the fault.

2.  https://issues.apache.org/jira/projects/COLLECTIONS/issues/COLLECTIONS-521?filter=doneissues Dans ce rapport de bug, il est question d'une erreur de typographie. Dans la fonction isEqualKey(entry,key1,key2), on return une valeur booléenne qui vaut (multi.size()==2) && (key1 == multi.getKey(0) || key1 != null && key1.equals(multi.getKey(0))) && (key2 == multi.getKey(1) || key1 != null && key2.equals(multi.getKey(1))). Ici, on vérifie que la taille est bien de 2, que la clé donnée en entrée key1 correspond bien à la première clé de multi et qu'elle est pas nulle, et que la clé key2 correspond bien à la deuxième. Cependant, il y a une typo et la vérification de key2!=null n'est pas faite. Cela cause un bug local?. La solution proposée et adoptée est de juste remplacer la dernière partie du booléen par (key2 != null && key2.equals(multi.getKey(1))) ce qui checkerai sa valeur. Un test a été ajouté pour vérifier si le deuxième paramètre est null, en renvoyant une NPE. Le test : MultiKeyMap<String, Long> map = new MultiKeyMap<String, Long>();
map.put("test", null, 2L);

3. Netflix 

4. [WebAssembly](https://webassembly.org/) has become the fourth official language supported by web browsers. The language was born from a joint effort of the major players in the Web. Its creators presented their design decisions and the formal specification in [a scientific paper](https://people.mpi-sws.org/~rossberg/papers/Haas,%20Rossberg,%20Schuff,%20Titzer,%20Gohman,%20Wagner,%20Zakai,%20Bastien,%20Holman%20-%20Bringing%20the%20Web%20up%20to%20Speed%20with%20WebAssembly.pdf) published in 2018. The goal of the language is to be a low level, safe and portable compilation target for the Web and other embedding environments. The authors say that it is the first industrial strength language designed with formal semantics from the start. This evidences the feasibility of constructive approaches in this area. Read the paper and explain what are the main advantages of having a formal specification for WebAssembly. In your opinion, does this mean that WebAssembly implementations should not be tested? 

5.  Shortly after the appearance of WebAssembly another paper proposed a mechanized specification of the language using Isabelle. The paper can be consulted here: https://www.cl.cam.ac.uk/~caw77/papers/mechanising-and-verifying-the-webassembly-specification.pdf. This mechanized specification complements the first formalization attempt from the paper. According to the author of this second paper, what are the main advantages of the mechanized specification? Did it help improving the original formal specification of the language? What other artifacts were derived from this mechanized specification? How did the author verify the specification? Does this new specification removes the need for testing?

## Answers