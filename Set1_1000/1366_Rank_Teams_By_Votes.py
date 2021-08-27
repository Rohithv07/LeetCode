class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        countCharacter = {v: [0] * len(votes[0]) + [v] for v in votes[0]}
        for vote in votes:
            for index, value in enumerate(vote):
                countCharacter[value][index] -= 1
        return ''.join(sorted(votes[0], key=countCharacter.get))
        
        
