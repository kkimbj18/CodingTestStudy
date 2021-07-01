#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    vector<string>::iterator iter;
    
    for(string target : participant){
        iter = find(completion.begin(), completion.end(), target);
        
        if(iter == completion.end()) {
            answer = target;
            break;
        }  
        else completion.erase(iter);
    }
    
    return answer;
}