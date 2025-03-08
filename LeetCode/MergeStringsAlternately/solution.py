def mergeAlternately(self, word1, word2):
    """
    :type word1: str
    :type word2: str
    :rtype: str
    """
    w1_pointer = 0
    w2_pointer = 0

    end_string = ""

    while (w1_pointer < len(word1) or w2_pointer < len(word2)):
        ## Single iteration
        if (w1_pointer < len(word1)):
            end_string = end_string + word1[w1_pointer]
            w1_pointer+=1
        if (w2_pointer < len(word2)):
            end_string = end_string + word2[w2_pointer]
            w2_pointer+=1


    return end_string



