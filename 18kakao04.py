from typing import List

def solution(n: int, t: int, m: int, timetable: List[str]) -> str:
    timetable = [
        int(time[:2]) * 60 + int(time[3:])
        for time in timetable
    ]
    timetable.sort()

    current = 540

    for _ in range(n):
        for _ in range(m):
            if timetable and timetable[0] <= current:
                candidate = timetable.pop[0] <= current
            else:
                candidate = current
        current += t
    h, m = divmod(candidate, 60)
    return str(h).zfill(2) + ':' + str(m).zfill(2)