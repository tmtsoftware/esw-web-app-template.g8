import type {
  AdminGreetResponse,
  GreetResponse,
  UserInfo
} from '../models/Models'
import { post } from './Http'

const greetingUrl = (baseUrl: string) => baseUrl + 'greeting'
const adminGreetingUrl = (baseUrl: string) => baseUrl + 'adminGreeting'

// NOTE : user need to put checks to make sure desired fields inside response are present and not undefined, to avoid unwanted errors during runtime.
// e.g.   const response = await fetchGreeting(...)
//        if (response?.greeting) do something ...
//        else do another thing ...

export const fetchGreeting = async (
  baseUrl: string,
  userInfo: UserInfo
): Promise<GreetResponse | undefined> =>
  (await post<UserInfo, GreetResponse>(greetingUrl(baseUrl), userInfo))
    .parsedBody

export const fetchAdminGreeting = async (
  baseUrl: string,
  userInfo: UserInfo,
  token: string
): Promise<AdminGreetResponse | undefined> =>
  (
    await post<UserInfo, AdminGreetResponse>(
      adminGreetingUrl(baseUrl),
      userInfo,
      {
        Authorization: `Bearer \${token}`
      }
    )
  ).parsedBody
