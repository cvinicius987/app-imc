package br.com.cvinicius.core.domain

fun defineClassification(result:Double):Classification{

    var classify:Classification? = null

    for(currentClassify in Classification.values()){

        if(currentClassify.predicate(result)){
            classify = currentClassify
            break
        }
    }

    return classify!!
}

enum class Classification(val category: String,
                          val table: String,
                          val predicate:(Double) -> Boolean){

    THINNESS("MAGREZA", "MENOR QUE 18,5", {result -> result <= 18.4}),
    NORMAL("NORMAL", "ENTRE 18,5 E 24,9", {result -> result in 18.5..24.9 }),
    OVERWEIGHT("SOBREPESO", "ENTRE 25,0 E 29,9", {result -> result in 25.0..29.9 }),
    OBESITY("OBESIDADE", "ENTRE 30,0 E 39,9", {result -> result in 30.0..39.9 }),
    SERIOUS_OBESITY("OBESIDADE GRAVE", "MAIOR QUE 40,0", {result -> result >= 40.0})
}
